package com.qihoo360.replugin.ext.parser.struct.xml;

import com.qihoo360.replugin.ext.parser.struct.ChunkHeader;

/**
 * Null header.
 *
 * @author dongliu
 */
public class NullHeader extends ChunkHeader {
    public NullHeader(int chunkType, int headerSize, long chunkSize) {
        super(chunkType, headerSize, chunkSize);
    }
}
