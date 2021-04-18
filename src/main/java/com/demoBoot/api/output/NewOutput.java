package com.demoBoot.api.output;

import com.demoBoot.dto.NewDTO;

import java.util.ArrayList;
import java.util.List;

public class NewOutput {
    private int page;
    private int totalPage;
    private List<NewDTO> result=new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<NewDTO> getResult() {
        return result;
    }

    public void setResult(List<NewDTO> result) {
        this.result = result;
    }
}
