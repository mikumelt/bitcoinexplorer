package io.dy.dto;

import java.util.Date;

public class BlockListDTO {

    private String blockhash;

    private Integer height;

    private Date time;

    private Integer txsize;

    private String chainwork;

    private Integer size;

    public String getBlockhash() {
        return blockhash;
    }

    public BlockListDTO setBlockhash(String blockhash) {
        this.blockhash = blockhash;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public BlockListDTO setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Date getTime() {
        return time;
    }

    public BlockListDTO setTime(Date time) {
        this.time = time;
        return this;
    }

    public Integer getTxsize() {
        return txsize;
    }

    public BlockListDTO setTxsize(Integer txsize) {
        this.txsize = txsize;
        return this;
    }

    public String getChainwork() {
        return chainwork;
    }

    public BlockListDTO setChainwork(String chainwork) {
        this.chainwork = chainwork;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public BlockListDTO setSize(Integer size) {
        this.size = size;
        return this;
    }
}
