package com.example.osonhisob.screens.peanutcalscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.osonhisob.R
import com.example.osonhisob.databinding.FragmentPeanutBinding
import com.example.osonhisob.utils.*


class PeanutFragment : Fragment() {


    private val spinValues1 = arrayListOf<ArrayList<String>>()
    private val spinValues2 = arrayListOf<ArrayList<String>>()
    private val spinValues3 = arrayListOf<ArrayList<String>>()
    private val spinValues4 = arrayListOf<ArrayList<String>>()
    private val spinValues5 = arrayListOf<ArrayList<String>>()
    private var resultReport = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentPeanutBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_peanut, container, false
        )

        activity!!.setTitle(R.string.penut_fragment_title)

        val application = requireNotNull(this.activity).application

        val viewModelFactory = PeanutViewModelFactory(application)

        val peanutViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(PeanutViewModel::class.java)

        binding.result.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(
                    PeanutFragmentDirections.actionPeanutFragmentToPeanutResultFragment(
                        resultReport
                    )
                )
        }

//        binding.history.setOnClickListener { v: View ->
//            v.findNavController()
//                .navigate(PeanutFragmentDirections.actionPeanutFragmentToHistoryFragment())
//        }


        initSpinners(binding)
        initClicks(binding, peanutViewModel)


        calculation(binding, peanutViewModel)




        return binding.root
    }


    private fun initClicks(binding: FragmentPeanutBinding, peanutViewModel: PeanutViewModel) {
        spinnerSelectedListener(binding.spinnerPeanut1, binding, peanutViewModel)
        spinnerSelectedListener(binding.spinnerPeanut2, binding, peanutViewModel)
        spinnerSelectedListener(binding.spinnerPeanut3, binding, peanutViewModel)
        spinnerSelectedListener(binding.spinnerPeanut4, binding, peanutViewModel)
        spinnerSelectedListener(binding.spinnerPeanut5, binding, peanutViewModel)

        TextChanged(binding.inputPeanut1, binding, peanutViewModel)
        TextChanged(binding.inputPeanut2, binding, peanutViewModel)
        TextChanged(binding.inputPeanut3, binding, peanutViewModel)
    }


    private fun initSpinners(binding: FragmentPeanutBinding) {
        //Spinner number 1
        spinValues1.add(
            arrayListOf(
                "30 %",
                "40 %",
                "45 %",
                "48 %",
                "50 %",
                "52 %",
                "54 %",
                "55 %",
                "56 %",
                "57 %",
                "58 %",
                "59 %",
                "60 %",
                "61 %",
                "62 %",
                "63 %",
                "64 %",
                "65 %",
                "66 %",
                "67 %",
                "68 %",
                "69 %",
                "70 %",
                "71 %",
                "72 %"
            )
        )


        binding.spinnerPeanut1.addItems(requireContext(), spinValues1[0])
        binding.spinnerPeanut1.setSelection(7)

        //Spinner number 2
        spinValues2.add(
            arrayListOf(
                "300 gr",
                "400 gr",
                "500 gr",
                "600 gr",
                "700 gr",
                "800 gr",
                "900 gr",
                "1 kg",
                "1.1 kg",
                "1.2 kg",
                "1.3 kg",
                "1.4 kg",
                "1.5 kg",
                "1.6 kg",
                "1.7 kg",
                "1.8 kg",
                "1.9 kg",
                "2 kg",
                "2.1 kg",
                "2.2 kg",
                "2.3 kg",
                "2.4 kg",
                "2.5 kg",
                "3 kg",
                "3.5 kg",
                "4 kg",
                "4.5 kg",
                "5 kg",
                "5.5 kg",
                "6 kg",
                "6.5 kg",
                "7 kg",
                "7.5 kg",
                "8 kg",
                "9 kg",
                "10 kg"
            )
        )


        binding.spinnerPeanut2.addItems(requireContext(), spinValues2[0])
        binding.spinnerPeanut2.setSelection(5)


        //Spinner number 3
        spinValues3.add(
            arrayListOf(
                "0.3 kg",
                "0.5 kg",
                "0.8 kg",
                "1 kg",
                "2 kg",
                "3 kg",
                "4 kg",
                "5 kg"
            )
        )


        binding.spinnerPeanut3.addItems(requireContext(), spinValues3[0])
        binding.spinnerPeanut3.setSelection(2)


        //Spinner 4

        //Spinner number 3
        spinValues4.add(
            arrayListOf(
                "1 kg",
                "2 kg",
                "3 kg",
                "4 kg",
                "5 kg",
                "6 kg",
                "7 kg",
                "8 kg",
                "9 kg",
                "10 kg",
                "11 kg",
                "12 kg",
                "13 kg",
                "14 kg",
                "15 kg",
                "16 kg",
                "17 kg",
                "18 kg",
                "19 kg",
                "20 kg",
                "21 kg",
                "22 kg",
                "23 kg",
                "24 kg",
                "25 kg",
                "26 kg",
                "27 kg",
                "28 kg",
                "29 kg",
                "30 kg"
            )
        )


        binding.spinnerPeanut4.addItems(requireContext(), spinValues4[0])
        binding.spinnerPeanut4.setSelection(1)


        //Spinner 5
        spinValues5.add(
            arrayListOf(
                "60 so'm",
                "70 so'm",
                "80 so'm",
                "100 so'm",
                "120 so'm",
                "150 so'm",
                "200 so'm",
                "250 so'm",
                "300 so'm"
            )
        )


        binding.spinnerPeanut5.addItems(requireContext(), spinValues5[0])
        binding.spinnerPeanut5.setSelection(3)


    }


    fun spinnerSelectedListener(
        spinner: Spinner,
        binding: FragmentPeanutBinding,
        peanutViewModel: PeanutViewModel
    ) {

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                //toast(context!!, "Spinner Changed")
                calculation(binding, peanutViewModel)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }
    }

    fun TextChanged(
        editText: EditText,
        binding: FragmentPeanutBinding,
        peanutViewModel: PeanutViewModel
    ) {

        editText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                //toast(context!!, "Text Changed")
                calculation(binding, peanutViewModel)
            }
        })
    }

    fun getTerishNarxi(spinner: Spinner): Double {
        var som = 0.0
        when (spinner.selectedItemPosition) {
            0 -> som = 60.0
            1 -> som = 70.0
            2 -> som = 80.0
            3 -> som = 100.0
            4 -> som = 120.0
            5 -> som = 150.0
            6 -> som = 200.0
            7 -> som = 250.0
            8 -> som = 300.0
        }


        return som
    }



    @SuppressLint("SetTextI18n")
    private fun calculation(binding: FragmentPeanutBinding, peanutViewModel: PeanutViewModel) {

        val input_text1 = binding.inputPeanut1.text.toString()
        val input_text2 = binding.inputPeanut2.text.toString()
        val input_text3 = binding.inputPeanut3.text.toString()

        val foizi = getFoiz(binding.spinnerPeanut1)
        val yRubb = getYongoqRubbish(binding.spinnerPeanut2)
        val mRubb = getMagizRubbish(binding.spinnerPeanut3)
        val mSechka = getMagizSechka(binding.spinnerPeanut4)
        val terishNarxi = getTerishNarxi(binding.spinnerPeanut5)

        if ((!input_text1.isEmpty()) && (!input_text2.isEmpty()) && (!input_text3.isEmpty())) {

            //Result 1
            var tannarxi = input_text1.toDouble() * input_text2.toDouble().toFloat()
            peanutViewModel.result1 = MutableLiveData(("%.1f".format(tannarxi) + " so'm"))

            //Result 2
            var tushganMagiz = 0.0

            var umumiyMagiz = (input_text1.toDouble() - (yRubb * input_text1.toDouble() / 100)) *
                    foizi
            tushganMagiz = umumiyMagiz - (mRubb * umumiyMagiz / 100)

            var tozaMagiz = tushganMagiz - mSechka * tushganMagiz / 100

            peanutViewModel.result2 = MutableLiveData("%.1f".format(tozaMagiz) + " kg")

            //Result 3
            var umumiySumma = (tozaMagiz * input_text3.toDouble())
            peanutViewModel.result3 = MutableLiveData("%.1f".format(umumiySumma) + " so'm")

            peanutViewModel.result4 = MutableLiveData(
                "%.1f".format((umumiySumma - tannarxi - tushganMagiz * terishNarxi)) + " so'm"
            )

            if (umumiySumma - tannarxi - tushganMagiz * terishNarxi > 0) {
                binding.foydaZarar.text = resources.getString(R.string.foyda)
            } else
                binding.foydaZarar.text = resources.getString(R.string.zarar)


        } else
            if ((!input_text1.isEmpty()) && (!input_text2.isEmpty())) {
                //Result 1
                var tannarxi = input_text1.toDouble() * input_text2.toDouble().toFloat()
                peanutViewModel.result1 = MutableLiveData(("%.1f".format(tannarxi) + " so'm"))

                //Result 2
                var tushganMagiz = 0.0

                var umumiyMagiz =
                    (input_text1.toDouble() - (yRubb * input_text1.toDouble() / 100)) * foizi

                tushganMagiz = umumiyMagiz - (mRubb * umumiyMagiz / 100)

                var tozaMagiz = tushganMagiz - mSechka * tushganMagiz / 100

                peanutViewModel.result2 = MutableLiveData("%.1f".format(tozaMagiz) + " kg")

            } else {
                peanutViewModel.result1 = MutableLiveData("0 so'm")
                peanutViewModel.result2 = MutableLiveData("0 kg")
                peanutViewModel.result3 = MutableLiveData("0 so'm")
                peanutViewModel.result4 = MutableLiveData("0 so'm")
            }

        resultReport =
            "Еслатма!!! \n умумий кило бу йер ёнғоқнинг чиқишига олингандаги килосини билдиради.\n Умумий кило = $input_text1 кг \n Йерёнъгоқ нархи = $input_text2 сум \n Фоизи бу неча працент мағиз тушишини билдиради \n Фоизи = ${
                "%.1f".format((foizi * 100))
            } % \n Йер ёнғоқни 100 кг га қанча кесак ёки бошқа мусор тушуши \n Ёнғоқ мусор = $yRubb кг \n Мағиз мусори 100 кг га қанча кесак ёки бошқа мусор тушуши \n Мағиз мусор = $mRubb кг \n Мағиз сечкаси 100 кг га қанча майдаси  тушуши \n" +
                    " Мағиз сечка  = $mSechka кг"

        peanutViewModel.result1.observe(viewLifecycleOwner, Observer {
            binding.peanutResult1.setText(it)
        })

        peanutViewModel.result2.observe(viewLifecycleOwner, Observer {
            binding.peanutResult2.setText(it)
        })

        peanutViewModel.result3.observe(viewLifecycleOwner, Observer {
            binding.peanutResult3.setText(it)
        })

        peanutViewModel.result4.observe(viewLifecycleOwner, Observer {
            binding.peanutResult4.setText(it)
        })


    }
}

