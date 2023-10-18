package com.qihoo360.replugin.ext.parser.struct.xml;

import com.qihoo360.replugin.ext.parser.struct.ChunkHeader;

/**
 * Binary XML header. It is simply a struct ResChunk_header.
 * The header.type is always 0×0003 (XML).
 *
 * @author dongliu
 */
public class XmlHeader extends ChunkHeader {
    public XmlHeader(int chunkType, int headerSize, long chunkSize) {
        super(chunkType, headerSize, chunkSize);
    }
}
