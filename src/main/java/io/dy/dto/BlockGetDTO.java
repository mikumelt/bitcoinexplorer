package io.dy.dto;

import java.util.Date;
import java.util.List;

public class BlockGetDTO {
    private String blockhash;

    private Integer confirmations;

    private Integer strippedsize;

    private Integer size;

    private Integer weight;

    private Integer height;

    private Integer version;

    private String merkleroot;

    private Date time;

    private Date receivedTime;

    private String relayedBy;

    private Integer nonce;

    private Integer difficulty;

    private String chainwork;

    private Integer txsize;

    private String nextBlock;

    private String prevBlock;

    private Double outputTotal;

    private Double fees;

    private Double blockReward;

    public List<String> transactionList;

    public String getBlockhash() {
        return blockhash;
    }

    public BlockGetDTO setBlockhash(String blockhash) {
        this.blockhash = blockhash;
        return this;
    }

    public Integer getConfirmations() {
        return confirmations;
    }

    public BlockGetDTO setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
        return this;
    }

    public Integer getStrippedsize() {
        return strippedsize;
    }

    public BlockGetDTO setStrippedsize(Integer strippedsize) {
        this.strippedsize = strippedsize;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public BlockGetDTO setSize(Integer size) {
        this.size = size;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public BlockGetDTO setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public BlockGetDTO setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

    public BlockGetDTO setVersion(Integer version) {
        this.version = version;
        return this;
    }

    public String getMerkleroot() {
        return merkleroot;
    }

    public BlockGetDTO setMerkleroot(String merkleroot) {
        this.merkleroot = merkleroot;
        return this;
    }

    public Date getTime() {
        return time;
    }

    public BlockGetDTO setTime(Date time) {
        this.time = time;
        return this;
    }

    public Date getReceivedTime() {
        return receivedTime;
    }

    public BlockGetDTO setReceivedTime(Date receivedTime) {
        this.receivedTime = receivedTime;
        return this;
    }

    public String getRelayedBy() {
        return relayedBy;
    }

    public BlockGetDTO setRelayedBy(String relayedBy) {
        this.relayedBy = relayedBy;
        return this;
    }

    public Integer getNonce() {
        return nonce;
    }

    public BlockGetDTO setNonce(Integer nonce) {
        this.nonce = nonce;
        return this;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public BlockGetDTO setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public String getChainwork() {
        return chainwork;
    }

    public BlockGetDTO setChainwork(String chainwork) {
        this.chainwork = chainwork;
        return this;
    }

    public Integer getTxsize() {
        return txsize;
    }

    public BlockGetDTO setTxsize(Integer txsize) {
        this.txsize = txsize;
        return this;
    }

    public String getNextBlock() {
        return nextBlock;
    }

    public BlockGetDTO setNextBlock(String nextBlock) {
        this.nextBlock = nextBlock;
        return this;
    }

    public String getPrevBlock() {
        return prevBlock;
    }

    public BlockGetDTO setPrevBlock(String prevBlock) {
        this.prevBlock = prevBlock;
        return this;
    }

    public Double getOutputTotal() {
        return outputTotal;
    }

    public BlockGetDTO setOutputTotal(Double outputTotal) {
        this.outputTotal = outputTotal;
        return this;
    }

    public Double getFees() {
        return fees;
    }

    public BlockGetDTO setFees(Double fees) {
        this.fees = fees;
        return this;
    }

    public Double getBlockReward() {
        return blockReward;
    }

    public BlockGetDTO setBlockReward(Double blockReward) {
        this.blockReward = blockReward;
        return this;
    }

    public List<String> getTransactionList() {
        return transactionList;
    }

    public BlockGetDTO setTransactionList(List<String> transactionList) {
        this.transactionList = transactionList;
        return this;
    }
}
