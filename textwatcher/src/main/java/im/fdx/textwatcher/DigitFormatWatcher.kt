package im.fdx.textwatcher

import android.text.Editable
import android.text.TextWatcher

/**
 * Created by fdx on 2018/4/2.
 */
class DigitFormatWatcher @JvmOverloads constructor(
        // Change this to what you want... ' ', '-' etc..
        private val space: Char = ' ',
        //Change this to how many character you what to separate
        private val interval: Int = 4) : TextWatcher {
    private var isChanging = false
    private var isDeleteAction: Boolean = false
    private var curPos = 0

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        isDeleteAction = before > 0 && count == 0
        curPos = start + count
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

    override fun afterTextChanged(s: Editable) {
        if (isChanging) {
            return
        }
        isChanging = true
        if (isDeleteAction) {
            if (curPos < s.length
                    && curPos % (interval + 1) == interval
                    && space != s[curPos]) {
                s.delete(curPos - 1, curPos)
            }
        }
        var pos = 0
        while (pos < s.length) {
            if (space == s[pos]) {
                s.delete(pos, pos + 1)
            } else {
                pos++
            }
        }

        // Insert char where needed.
        var i = interval
        while (i < s.length) {
            s.insert(i, "" + space)
            i += interval + 1
        }
        isChanging = false
    }
}