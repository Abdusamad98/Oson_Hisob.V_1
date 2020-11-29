package com.example.osonhisob.screens.terma

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.osonhisob.R
import com.example.osonhisob.databinding.FragmentTermaBinding
import com.example.osonhisob.utils.*


class TermaFragment : Fragment() {

    private lateinit var viewModel: TermaViewModel

    private val spinValues1 = arrayListOf<ArrayList<String>>()
    private val spinValues2 = arrayListOf<ArrayList<String>>()
    private val spinValues3 = arrayListOf<ArrayList<String>>()
    private val spinValues4 = arrayListOf<ArrayList<String>>()
    private val spinValues5 = arrayListOf<ArrayList<String>>()
    private val spinValues6 = arrayListOf<ArrayList<String>>()
    private var resultReport = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTermaBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_terma, container, false
        )

        activity!!.setTitle(R.string.terma_fragment_title)

        //val application = requireNotNull(this.activity).application

        // val viewModelFactory = PeanutViewModelFactory(application)

        viewModel = ViewModelProvider(this).get(TermaViewModel::class.java)

        binding.result.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(
                    TermaFragmentDirections.actionTermaFragmentToPeanutResultFragment(
                        resultReport
                    )
                )
        }


        initSpinners(binding)
        initClicks(binding)

        calculation(binding)

        return binding.root
    }


    private fun initClicks(binding: FragmentTermaBinding) {
        spinnerSelectedListener(binding.spinnerYongoq1, binding)
        spinnerSelectedListener(binding.spinnerYongoq2, binding)
        spinnerSelectedListener(binding.spinnerYongoq3, binding)
        spinnerSelectedListener(binding.spinnerYongoq4, binding)
        spinnerSelectedListener(binding.spinnerYongoq5, binding)
        spinnerSelectedListener(binding.spinnerYongoq6, binding)

        TextChanged(binding.inputYongoq1, binding)
        TextChanged(binding.inputYongoq2, binding)
        TextChanged(binding.inputYongoq3, binding)
        TextChanged(binding.inputYongoq4, binding)
    }


    private fun initSpinners(binding: FragmentTermaBinding) {
        //Spinner number 1

        spinValues1.add(
            arrayListOf(
                "50 %",
                "51 %",
                "52 %",
                "53 %",
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
                "72 %",
                "73 %",
                "74 %",
                "75 %",
                "76 %",
                "77 %",
                "78 %",
                "79 %",
                "80 %",
                "81 %",
                "82 %",
                "83 %",
                "84 %",
                "85 %",
                "86 %"
            )
        )


        binding.spinnerYongoq1.addItems(requireContext(), spinValues1[0])
        binding.spinnerYongoq1.setSelection(15)


        //Spinner number 2
        spinValues2.add(
            arrayListOf(
                "200 so'm",
                "250 so'm",
                "300 so'm",
                "350 so'm",
                "400 so'm",
                "450 so'm",
                "500 so'm",
                "550 so'm",
                "600 so'm"
            )
        )


        binding.spinnerYongoq2.addItems(requireContext(), spinValues2[0])
        binding.spinnerYongoq2.setSelection(3)


        //Spinner number 3
        spinValues3.add(
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


        binding.spinnerYongoq3.addItems(requireContext(), spinValues3[0])
        binding.spinnerYongoq3.setSelection(5)







        spinValues4.add(
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


        binding.spinnerYongoq4.addItems(requireContext(), spinValues4[0])
        binding.spinnerYongoq4.setSelection(7)


        //Spinner number 5
        spinValues5.add(
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


        binding.spinnerYongoq5.addItems(requireContext(), spinValues5[0])
        binding.spinnerYongoq5.setSelection(1)


        //Spinner number 3
        spinValues6.add(
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
        binding.spinnerYongoq6.addItems(requireContext(), spinValues6[0])
        binding.spinnerYongoq6.setSelection(2)
    }


    fun spinnerSelectedListener(
        spinner: Spinner,
        binding: FragmentTermaBinding
    ) {

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                calculation(binding)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }
    }

    fun TextChanged(
        editText: EditText,
        binding: FragmentTermaBinding,
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
                calculation(binding)
            }
        })
    }



    @SuppressLint("SetTextI18n")
    private fun calculation(binding: FragmentTermaBinding) {

        val text1 = binding.inputYongoq1.text.toString()
        val text2 = binding.inputYongoq2.text.toString()
        val text3 = binding.inputYongoq3.text.toString()
        val text4 = binding.inputYongoq4.text.toString()

        val input_text1 = text1
        val input_text2 = text2
        val input_text3 = text3
        val input_text4 = text4


        val magizMususri = getMagizRubbish(binding.spinnerYongoq6)
        val magizSechka = getMagizSechka(binding.spinnerYongoq5)
        val termaFoizi = getTermaFoiz(binding.spinnerYongoq1)
        val terishNarxi = getTerishNarxi(binding.spinnerYongoq2)
        val qolganYongoqMusuri = getYongoqRubbish(binding.spinnerYongoq3)
        val magizFoizi = getFoiz(binding.spinnerYongoq4)







        if ((!text1.isEmpty()) && (!text2.isEmpty()) && (!text3.isEmpty()) && (!text4.isEmpty())) {


            //Result 1
            var tannarxi = input_text1.toDouble() * input_text2.toFloat()
            viewModel.result1 = MutableLiveData(("%.1f".format(tannarxi) + " so'm"))

            //Result 2
            var termaYongoq = termaFoizi * input_text1.toDouble()

            viewModel.result2 = MutableLiveData("%.1f".format(termaYongoq) + " kg")

            //Result 3
            var pushqit = input_text1.toDouble() * (1 - termaFoizi)
            var tozaPushqit = pushqit - qolganYongoqMusuri * pushqit / 100

            var magiz = tozaPushqit * magizFoizi
            var tozaMagiz = magiz - magizMususri * magiz / 100
            var elanganMagiz = tozaMagiz - magizSechka * tozaMagiz / 100

            viewModel.result3 = MutableLiveData("%.1f".format(elanganMagiz) + " kg")

            //Result 4
            var sotilganSummasi = termaYongoq * input_text3.toDouble() + elanganMagiz * input_text4.toDouble()

            viewModel.result4 = MutableLiveData("%.1f".format(sotilganSummasi) + " so'm")


            //Result 5

            var foyda = sotilganSummasi - tannarxi - terishNarxi*termaYongoq
            viewModel.result5 = MutableLiveData("%.1f".format(foyda) + " so'm")


            if (foyda > 0) {
                binding.foydaZarar.text = resources.getString(R.string.foyda)
            } else
                binding.foydaZarar.text = resources.getString(R.string.zarar)


        } else
            if ((!text1.isEmpty()) && (!text2.isEmpty()) && (!text3.isEmpty())) {


                //Result 1
                var tannarxi = input_text1.toDouble() * input_text2.toFloat()
                viewModel.result1 = MutableLiveData(("%.1f".format(tannarxi) + " so'm"))

                //Result 2
                var termaYongoq = termaFoizi * input_text1.toDouble()

                viewModel.result2 = MutableLiveData("%.1f".format(termaYongoq) + " kg")

                //Result 3
                var pushqit = input_text1.toDouble() * (1 - termaFoizi)
                var tozaPushqit = pushqit - qolganYongoqMusuri * pushqit / 100

                var magiz = tozaPushqit * magizFoizi
                var tozaMagiz = magiz - magizMususri * magiz / 100
                var elanganMagiz = tozaMagiz - magizSechka * tozaMagiz / 100

                viewModel.result3 = MutableLiveData("%.1f".format(elanganMagiz) + " kg")

                //Result 4
                var sotilganSummasi = termaYongoq * input_text3.toDouble()

                viewModel.result4 = MutableLiveData("%.1f".format(sotilganSummasi) + " so'm")

                toast(context!!, "Енди мағизни нархини киритинг")
                //Result 5

                var foyda = sotilganSummasi - tannarxi - terishNarxi*termaYongoq
                viewModel.result5 = MutableLiveData("%.1f".format(foyda) + " so'm")


                if (foyda > 0) {
                    binding.foydaZarar.text = resources.getString(R.string.foyda)
                } else
                    binding.foydaZarar.text = resources.getString(R.string.zarar)


            } else
                if ((!text1.isEmpty()) && (!text2.isEmpty())) {

                    //Result 1
                    var tannarxi = input_text1.toDouble() * input_text2.toFloat()
                    viewModel.result1 = MutableLiveData(("%.1f".format(tannarxi) + " so'm"))

                    //Result 2
                    var termaYongoq = termaFoizi * input_text1.toDouble()

                    viewModel.result2 = MutableLiveData("%.1f".format(termaYongoq) + " kg")

                    //Result 3
                    var pushqit = input_text1.toDouble() * (1 - termaFoizi)
                    var tozaPushqit = pushqit - qolganYongoqMusuri * pushqit / 100

                    var magiz = tozaPushqit * magizFoizi
                    var tozaMagiz = magiz - magizMususri * magiz / 100
                    var elanganMagiz = tozaMagiz - magizSechka * tozaMagiz / 100

                    viewModel.result3 = MutableLiveData("%.1f".format(elanganMagiz) + " kg")


                    viewModel.result4 = MutableLiveData("0 so'm")
                    viewModel.result5 = MutableLiveData("0 so'm")

                } else {
                    viewModel.result1 = MutableLiveData("0 so'm")
                    viewModel.result2 = MutableLiveData("0 кг")
                    viewModel.result3 = MutableLiveData("0 кг")
                    viewModel.result4 = MutableLiveData("0 so'm")
                    viewModel.result5 = MutableLiveData("0 so'm")
                }


        resultReport="Еслатма!!! Бу йерда умумий кило деганда йерёнғоқнинг умумий оғирлиги назарда тутилган. Нархи еса унинг олинган нархини ҳамда терма фоизи унинг неча фоиз терма беришлигини англатади. Териш нархи бу 1 кг терма ёнғоқнинг териш нархи. Қолган ёнғоқ чиқиндиси еса бу оқи териб олинганидан қолган йерёнғоқнинг ҳар 100 кг дан чиқган чиқниди. Мағиз фоизи бу қолган ёнғоқдан тушадиган мағиз улушини билдиради. Сечкаси бу тушган тоза мағизнинг ҳар 100 кг га қанча майдаси тўғри келишини англатади."


        viewModel.result1.observe(viewLifecycleOwner, Observer {
            binding.yongoqResult1.setText(it)
        })

        viewModel.result2.observe(viewLifecycleOwner, Observer {
            binding.yongoqResult2.setText(it)
        })

        viewModel.result3.observe(viewLifecycleOwner, Observer {
            binding.yongoqResult3.setText(it)
        })

        viewModel.result4.observe(viewLifecycleOwner, Observer {
            binding.yongoqResult4.setText(it)
        })

        viewModel.result5.observe(viewLifecycleOwner, Observer {
            binding.yongoqResult5.setText(it)
        })

    }
}

