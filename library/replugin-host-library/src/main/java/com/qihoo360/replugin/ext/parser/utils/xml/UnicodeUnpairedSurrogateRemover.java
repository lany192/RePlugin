
package com.qihoo360.replugin.ext.parser.utils.xml;

import java.io.IOException;
import java.io.Writer;

/**
 * Helper subclass to CharSequenceTranslator to remove unpaired surrogates.
 */
class UnicodeUnpairedSurrogateRemover extends CodePointTranslator {
    /**
     * Implementation of translate that throws out unpaired surrogates.
     * {@inheritDoc}
     */
    @Override
    public boolean translate(int codepoint, Writer out) throws IOException {
        if (codepoint >= Character.MIN_SURROGATE && codepoint <= Character.MAX_SURROGATE) {
            // It's a surrogate. Write nothing and say we've translated.
            return true;
        } else {
            // It's not a surrogate. Don't translate it.
            return false;
        }
    }
}

