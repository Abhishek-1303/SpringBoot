package com.example.restapi.VO;


public class Body {
    private SearchResult  searchResults;

    public SearchResult getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(SearchResult searchResults) {
        this.searchResults = searchResults;
    }

    @Override
    public String toString() {
        return "Body{" +
                "searchResults=" + searchResults +
                '}';
    }
}
