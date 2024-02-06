package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.myfirstapplication.databinding.RelativeLayoutBinding
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {

    private var _binding: RelativeLayoutBinding? = null
    private val binding: RelativeLayoutBinding get() = _binding!!
    private val lsCurrentCharacters = ArrayList<SymbolData>(8)
    private val lsQuest = loadQuest()
    private var removeCount = 3
    private var openCount = 1
    private var currentData: QuestData? = null
    private var correctCount = 0
    private var currentIndex = 0
    private var existElementCount = 0

    private var inputLs = Array(8) {
        SymbolData(
            -1, ' '
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
        binding.toolbar.title = text ?: "Empty"
        initializeNewWord()
        loadUiClickable()
    }

    private fun loadUiClickable() {
        characterClickable()
        currentWordCharacterClickable()
        binding.nextBtn.setOnClickListener {
            /**
             * barcha so`zlar to`ldirilganmi
             */
            if (existElementCount < (currentData?.word?.length ?: 0)) {
                Toast.makeText(this, "Belgilani to`ldiring", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            /**
             * so`z tog`ri kiritilganmi
             */
            var currentText = ""
            inputLs.forEach {
                currentText += it.character
            }
            if ((currentData?.word ?: "").equals(currentText.trim(), true)) {
                correctCount++
            }

            /**
             * list malumotlari tugadi
             */
            currentIndex++
            if (currentIndex < lsQuest.size) {

                initializeNewWord()
            } else {
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra("username", binding.toolbar.title.toString())
                intent.putExtra("correctCount", correctCount.toString())
                startActivity(intent)
            }
        }

        binding.helpOpenBtn.setOnClickListener {
            if (openCount <= 0) {
                return@setOnClickListener
            }
            openCount--
            existElementCount++
            var i = 0
            while (i < 8) {
                if (inputLs[i].id == -1) {
                    inputLs[i] =
                        SymbolData(8, currentData?.word?.uppercase()?.getOrNull(i) ?: ' ', false)
                    i = 8
                }
                i++
            }
            setSymbols()
        }

        binding.helpRemoveBtn.setOnClickListener {
            if (removeCount <= 0)
                return@setOnClickListener
            lsCurrentCharacters.forEach {
                if (currentData?.word?.contains(it.character, true) == false && it.isShow) {
                    it.isShow = false
                    removeCount--
                    relieseCurrentWordVisibility()
                    return@setOnClickListener
                }
            }
        }
    }

    /**
     * initial word
     */
    private fun initializeNewWord() {
        existElementCount = 0
        currentData = lsQuest[currentIndex]
        inputLs = Array(8) {
            SymbolData(
                -1, ' '
            )
        }
        loadImageText()
        loadImage(currentData ?: lsQuest[currentIndex])
        initialWord()
        submitSymbol()
    }

    /**
     * sozga kerakli belgilarni ko`rsatib beruvchi funksiya
     */
    private fun loadImageText() {
        val size = currentData?.word?.length ?: 0
        binding.name0.text = ""
        binding.name1.text = ""
        binding.name2.text = ""
        binding.name3.text = ""
        binding.name4.text = ""
        binding.name5.text = ""
        binding.name6.text = ""
        binding.name7.text = ""
        binding.name0.isVisible = size > 0
        binding.name1.isVisible = size > 1
        binding.name2.isVisible = size > 2
        binding.name3.isVisible = size > 3
        binding.name4.isVisible = size > 4
        binding.name5.isVisible = size > 5
        binding.name6.isVisible = size > 6
        binding.name7.isVisible = size > 7
    }

    /**
     * bu imagelarni joylashtiradigan funksiya
     */
    private fun loadImage(data: QuestData) {
        binding.image1.setImageResource(data.imageOne)
        binding.image2.setImageResource(data.imageTwo)
        binding.image3.setImageResource(data.imageThree)
        binding.image4.setImageResource(data.imageFour)
    }

    /**
     * bu so`zda bor belgilarni va boshqa beligilar listini yasab beruvchi funksiya
     */
    private fun initialWord() {
        lsCurrentCharacters.clear()
        val lsCharacters = ArrayList<Char>()
        (currentData?.word ?: "").uppercase().forEach {
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
        relieseCurrentWordVisibility()
    }

    /**
     * bu ixtiyoriy biror belgini oluvchi funksiya
     */
    private fun getCharRandom(): Char {
        val index = Random.nextInt(65, 91)
        return index.toChar()
    }

    /**
     * bu so`zni yasash uchun kerak bo`ladigan beligilarni soluvchi funksiya
     */
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

    /**
     *  bu so`zni quradigan belgilar bosilish funksinalligi
     */
    private fun characterClickable() {
        binding.character0.setOnClickListener {
            clickShuffleCharacter(it, 0)
        }
        binding.character1.setOnClickListener {
            clickShuffleCharacter(it, 1)
        }
        binding.character2.setOnClickListener {
            clickShuffleCharacter(it, 2)
        }
        binding.character3.setOnClickListener {
            clickShuffleCharacter(it, 3)
        }
        binding.character4.setOnClickListener {
            clickShuffleCharacter(it, 4)
        }
        binding.character5.setOnClickListener {
            clickShuffleCharacter(it, 5)
        }
        binding.character6.setOnClickListener {
            clickShuffleCharacter(it, 6)
        }
        binding.character7.setOnClickListener {
            clickShuffleCharacter(it, 7)
        }
        binding.character8.setOnClickListener {
            clickShuffleCharacter(it, 8)
        }
        binding.character9.setOnClickListener {
            clickShuffleCharacter(it, 9)
        }
        binding.character10.setOnClickListener {
            clickShuffleCharacter(it, 10)
        }
        binding.character11.setOnClickListener {
            clickShuffleCharacter(it, 11)
        }
        binding.character12.setOnClickListener {
            clickShuffleCharacter(it, 12)
        }
        binding.character13.setOnClickListener {
            clickShuffleCharacter(it, 13)
        }
        binding.character14.setOnClickListener {
            clickShuffleCharacter(it, 14)
        }
        binding.character15.setOnClickListener {
            clickShuffleCharacter(it, 15)
        }

    }

    /**
     *  bu so`zni yasash uchun kerak bo`ladigan belgilar bosilishi
     */
    private fun clickShuffleCharacter(view: View, index: Int) {
        if (existElementCount >= (currentData?.word ?: "").length)
            return
        existElementCount++
        view.visibility = View.INVISIBLE
        lsCurrentCharacters[index].isShow = false
        var i = 0
        while (i < 8) {
            if (inputLs[i].id == -1) {
                inputLs[i] = lsCurrentCharacters[index]
                i = 8
            }
            i++
        }
        relieseCurrentWordVisibility()
    }

    private fun relieseCurrentWordVisibility() {
        lsCurrentCharacters.forEach { symbolData ->
            when (symbolData.id) {
                0 -> binding.character0.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE

                1 -> binding.character1.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE

                2 -> binding.character2.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE

                3 -> binding.character3.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE

                4 -> binding.character4.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE

                5 -> binding.character5.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE

                6 -> binding.character6.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE

                7 -> binding.character7.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE

                8 -> binding.character8.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE

                9 -> binding.character9.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE

                10 -> binding.character10.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE

                11 -> binding.character11.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE

                12 -> binding.character12.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE

                13 -> binding.character13.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE

                14 -> binding.character14.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE

                15 -> binding.character15.visibility =
                    if (symbolData.isShow) View.VISIBLE else View.INVISIBLE
            }
        }
        setSymbols()
    }

    private fun setSymbols() {
        inputLs.forEachIndexed { index, symbolData ->
            when (index) {
                0 -> binding.name0.text = symbolData.character.toString()
                1 -> binding.name1.text = symbolData.character.toString()
                2 -> binding.name2.text = symbolData.character.toString()
                3 -> binding.name3.text = symbolData.character.toString()
                4 -> binding.name4.text = symbolData.character.toString()
                5 -> binding.name5.text = symbolData.character.toString()
                6 -> binding.name6.text = symbolData.character.toString()
                7 -> binding.name7.text = symbolData.character.toString()
                else -> {}
            }
        }
    }

    private fun currentWordCharacterClickable() {

        binding.name0.setOnClickListener {
            if (inputLs[0].isShow)
                return@setOnClickListener
            existElementCount--
            inputLs[0].isShow = true
            inputLs[0] = SymbolData(-1, ' ')
            relieseCurrentWordVisibility()
        }
        binding.name1.setOnClickListener {
            if (inputLs[1].isShow)
                return@setOnClickListener
            existElementCount--
            inputLs[1].isShow = true
            inputLs[1] = SymbolData(-1, ' ')
            relieseCurrentWordVisibility()
        }
        binding.name2.setOnClickListener {
            if (inputLs[2].isShow)
                return@setOnClickListener
            existElementCount--
            inputLs[2].isShow = true
            inputLs[2] = SymbolData(-1, ' ')
            relieseCurrentWordVisibility()
        }
        binding.name3.setOnClickListener {
            if (inputLs[3].isShow)
                return@setOnClickListener
            existElementCount--
            inputLs[3].isShow = true
            inputLs[3] = SymbolData(-1, ' ')
            relieseCurrentWordVisibility()
        }
        binding.name4.setOnClickListener {
            if (inputLs[4].isShow)
                return@setOnClickListener
            existElementCount--
            inputLs[4].isShow = true
            inputLs[4] = SymbolData(-1, ' ')
            relieseCurrentWordVisibility()
        }
        binding.name5.setOnClickListener {
            if (inputLs[5].isShow)
                return@setOnClickListener
            existElementCount--
            inputLs[5].isShow = true
            inputLs[5] = SymbolData(-1, ' ')
            relieseCurrentWordVisibility()
        }
        binding.name6.setOnClickListener {
            if (inputLs[6].isShow)
                return@setOnClickListener
            existElementCount--
            inputLs[6].isShow = true
            inputLs[6] = SymbolData(-1, ' ')
            relieseCurrentWordVisibility()
        }
        binding.name7.setOnClickListener {
            if (inputLs[7].isShow)
                return@setOnClickListener
            existElementCount--
            inputLs[7].isShow = true
            inputLs[7] = SymbolData(-1, ' ')
            relieseCurrentWordVisibility()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}