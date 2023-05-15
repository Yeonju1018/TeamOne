package com.recipeone.service;

import java.util.List;
public interface RecipeSampleService {
    static class RecipeIdExistException extends Exception{
    }
    List<Long> searched(String keyword) throws RecipeIdExistException;
//추가
List<String> recommendKeywords(String keyword) throws RecipeIdExistException;
}
