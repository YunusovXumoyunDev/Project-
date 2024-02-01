package com.example.myfirstapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.myfirstapplication.databinding.RelativeLayoutBinding
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {

    private var _binding: RelativeLayoutBinding? = null
    private val binding: RelativeLayoutBinding get() = _binding!!
    private val lsCurrentCharacters = ArrayList<SymbolData>(8)
    private var removeCount = 3
    private var openCount = 1
    private var imageWrd = "Animal"

    private var inputLs = Array(8) {
        SymbolData(
            -1,' '
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = RelativeLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = intent.getStringExtra("username")
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
        loadImageText()
        initialWord()
        submitSymbol()
        characterClickable()
        wordClickable()
        binding.toolbar.title = text ?: "Empty"
    }

    private fun loadImageText() {
        val size = imageWrd.length
        binding.name0.isVisible = size > 0
        binding.name1.isVisible = size > 1
        binding.name2.isVisible = size > 2
        binding.name3.isVisible = size > 3
        binding.name4.isVisible = size > 4
        binding.name5.isVisible = size > 5
        binding.name6.isVisible = size > 6
        binding.name7.isVisible = size > 7

    }

    private fun initialWord() {
        val lsCharacters = ArrayList<Char>()
        imageWrd.uppercase().forEach {
            lsCharacters.add(
                it
            )
        }
        while (lsCharacters.size < 16) {
            lsCharacters.add(
                getCharRandom()
            )
        }
        lsCharacters.shuffle()
        lsCharacters.forEach {
            lsCurrentCharacters.add(
                SymbolData(
                    lsCurrentCharacters.size,
                    it
                )
            )
        }
    }

    private fun getCharRandom(): Char {
        val index = Random.nextInt(65, 91)
        return index.toChar()
    }

    private fun submitSymbol() {
        binding.character0.text = (lsCurrentCharacters.getOrNull(0)?.character ?: "").toString()
        binding.character1.text = (lsCurrentCharacters.getOrNull(1)?.character ?: "").toString()
        binding.character2.text = (lsCurrentCharacters.getOrNull(2)?.character ?: "").toString()
        binding.character3.text = (lsCurrentCharacters.getOrNull(3)?.character ?: "").toString()
        binding.character4.text = (lsCurrentCharacters.getOrNull(4)?.character ?: "").toString()
        binding.character5.text = (lsCurrentCharacters.getOrNull(5)?.character ?: "").toString()
        binding.character6.text = (lsCurrentCharacters.getOrNull(6)?.character ?: "").toString()
        binding.character7.text = (lsCurrentCharacters.getOrNull(7)?.character ?: "").toString()
        binding.character8.text = (lsCurrentCharacters.getOrNull(8)?.character ?: "").toString()
        binding.character9.text = (lsCurrentCharacters.getOrNull(9)?.character ?: "").toString()
        binding.character10.text = (lsCurrentCharacters.getOrNull(10)?.character ?: "").toString()
        binding.character11.text = (lsCurrentCharacters.getOrNull(11)?.character ?: "").toString()
        binding.character12.text = (lsCurrentCharacters.getOrNull(12)?.character ?: "").toString()
        binding.character13.text = (lsCurrentCharacters.getOrNull(13)?.character ?: "").toString()
        binding.character14.text = (lsCurrentCharacters.getOrNull(14)?.character ?: "").toString()
        binding.character15.text = (lsCurrentCharacters.getOrNull(15)?.character ?: "").toString()
    }

    private fun characterClickable() {
        binding.character0.setOnClickListener {
            clickCharacter(it,0)
        }
        binding.character1.setOnClickListener {
            clickCharacter(it,1)
        }
        binding.character2.setOnClickListener {
            clickCharacter(it,2)
        }
        binding.character3.setOnClickListener {
            clickCharacter(it,3)
        }
        binding.character4.setOnClickListener {
            clickCharacter(it,4)
        }
        binding.character5.setOnClickListener {
            clickCharacter(it,5)
        }
        binding.character6.setOnClickListener {
            clickCharacter(it,6)
        }
        binding.character7.setOnClickListener {
            clickCharacter(it,7)
        }
        binding.character8.setOnClickListener {
            clickCharacter(it,8)
        }
        binding.character9.setOnClickListener {
            clickCharacter(it,9)
        }
        binding.character10.setOnClickListener {
            clickCharacter(it,10)
        }
        binding.character11.setOnClickListener {
            clickCharacter(it,11)
        }
        binding.character12.setOnClickListener {
            clickCharacter(it,12)
        }
        binding.character13.setOnClickListener {
            clickCharacter(it,13)
        }
        binding.character14.setOnClickListener {
            clickCharacter(it,14)
        }
        binding.character15.setOnClickListener {
            clickCharacter(it,15)
        }

    }

    private fun clickCharacter(view: View, index:Int){
        view.visibility = View.INVISIBLE
        lsCurrentCharacters[index].isShow=false
        var i=0
        while (i<8){
            if (inputLs[i].id==-1){
                inputLs[i]=lsCurrentCharacters[index]
                i=8
            }
            i++
        }
        checkWord()
    }

    private fun checkWord() {

        lsCurrentCharacters.forEach { symbolData ->
            when (symbolData.id) {
                0 -> binding.character0.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
                1 -> binding.character1.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
                2 -> binding.character2.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
                3 -> binding.character3.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
                4 -> binding.character4.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
                5 -> binding.character5.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
                6 -> binding.character6.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
                7 -> binding.character7.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
                8 -> binding.character8.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
                9 -> binding.character9.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
                10 -> binding.character10.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
                11 -> binding.character11.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
                12 -> binding.character12.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
                13 -> binding.character13.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
                14 -> binding.character14.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
                15 -> binding.character15.visibility = if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
            }
        }
        inputLs.forEachIndexed { index, symbolData ->
            when(index){
                0->binding.name0.text=symbolData.character.toString()
                1->binding.name1.text=symbolData.character.toString()
                2->binding.name2.text=symbolData.character.toString()
                3->binding.name3.text=symbolData.character.toString()
                4->binding.name4.text=symbolData.character.toString()
                5->binding.name5.text=symbolData.character.toString()
                6->binding.name6.text=symbolData.character.toString()
                7->binding.name7.text=symbolData.character.toString()
                else->{}
            }
        }
    }

    private fun wordClickable() {
        binding.name0.setOnClickListener {
            inputLs[0].isShow=true
            inputLs[0]= SymbolData(-1,' ')
            checkWord()
        }
        binding.name1.setOnClickListener {
            inputLs[1].isShow=true
            inputLs[1]=SymbolData(-1,' ')
            checkWord()
        }
        binding.name2.setOnClickListener {
            inputLs[2].isShow=true
            inputLs[2]=SymbolData(-1,' ')
            checkWord()
        }
        binding.name3.setOnClickListener {
            inputLs[3].isShow=true
            inputLs[3]=SymbolData(-1,' ')
            checkWord()
        }
        binding.name4.setOnClickListener {
            inputLs[4].isShow=true
            inputLs[4]=SymbolData(-1,' ')
            checkWord()
        }
        binding.name5.setOnClickListener {
            inputLs[5].isShow=true
            inputLs[5]=SymbolData(-1,' ')
            checkWord()
        }
        binding.name6.setOnClickListener {
            inputLs[6].isShow=true
            inputLs[6]=SymbolData(-1,' ')
            checkWord()
        }
        binding.name7.setOnClickListener {
            inputLs[7].isShow=true
            inputLs[7]=SymbolData(-1,' ')
            checkWord()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}