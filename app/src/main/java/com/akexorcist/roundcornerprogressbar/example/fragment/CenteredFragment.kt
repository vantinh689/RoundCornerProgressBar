package com.akexorcist.roundcornerprogressbar.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akexorcist.roundcornerprogressbar.example.R
import kotlinx.android.synthetic.main.fragment_centered.*

class CenteredFragment : Fragment() {
    companion object {
        fun newInstance(): Fragment = CenteredFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_centered, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewCentered1.text = getSimple1Description()
        textViewCentered2.text = getSimple2Description()
        textViewCentered3.text = getSimple3Description()
        textViewCentered4.text = getSimple4Description()
        textViewCentered5.text = getSimple5Description()
        buttonSimpleCustomIncrease.setOnClickListener { increaseCustomProgress() }
        buttonSimpleCustomExtraIncrease.setOnClickListener { extraIncreaseCustomProgress() }
        buttonSimpleCustomDecrease.setOnClickListener { decreaseCustomProgress() }
        buttonSimpleCustomExtraDecrease.setOnClickListener { extraDecreaseCustomProgress() }
        checkBoxAnimationEnable.setOnCheckedChangeListener { _, isChecked -> onAnimationEnableCheckdChange(isChecked) }
        progressBarCenteredCustom.setOnProgressChangedListener { _, _, isPrimaryProgress, _ ->
            if (isPrimaryProgress) {
                updateCustomProgressText()
            }
        }
        updateCustomProgressText()
    }

    private fun onAnimationEnableCheckdChange(isChecked: Boolean) {
        if (isChecked) {
            progressBarCenteredCustom.enableAnimation()
        } else {
            progressBarCenteredCustom.disableAnimation()
        }
    }

    private fun increaseCustomProgress() {
        progressBarCenteredCustom.progress = progressBarCenteredCustom.progress + 2
        updateCustomSecondaryProgress()
    }

    private fun extraIncreaseCustomProgress() {
        progressBarCenteredCustom.progress = progressBarCenteredCustom.progress + 20
        updateCustomSecondaryProgress()
    }

    private fun decreaseCustomProgress() {
        progressBarCenteredCustom.progress = progressBarCenteredCustom.progress - 2
        updateCustomSecondaryProgress()
    }

    private fun extraDecreaseCustomProgress() {
        progressBarCenteredCustom.progress = progressBarCenteredCustom.progress - 20
        updateCustomSecondaryProgress()
    }

    private fun updateCustomSecondaryProgress() {
        progressBarCenteredCustom.secondaryProgress = progressBarCenteredCustom.progress + 10
    }

    private fun updateCustomProgressText() {
        textViewSimpleCustom.text = String.format("%.0f", progressBarCenteredCustom.progress)
    }

    private fun getSimple1Description() = """
    |Max : 100
    |Progress : 50
    |Radius : 0dp
    |Padding : 4dp
    |Width : 250dp
    |Height : 30dp
    """.trimMargin()

    private fun getSimple2Description() = """
    |Max : 100
    |Progress : 40
    |SecondaryProgress : 60
    |Radius : 10dp
    |Padding : 2dp
    |Width : 250dp
    |Height : 30dp
    """.trimMargin()

    private fun getSimple3Description() = """
    |Max : 100
    |Progress : 20
    |SecondaryProgress : 75
    |Radius : 80dp
    |Padding : 2dp
    |Reverse : True
    |Width : 250dp
    |Height : 30dp
    """.trimMargin()

    private fun getSimple4Description() = """
    |Max : 100
    |Progress : 80
    |Radius : 20dp
    |Padding : 2dp
    |Width : 250dp
    |Height : 20dp
    """.trimMargin()

    private fun getSimple5Description() = """
    |Max : 200
    |Progress : 20
    |Radius : 20dp
    |Padding : 10dp
    |Width : 250dp
    |Height : 50dp
    """.trimMargin()
}