package com.recipeone.service;

import com.recipeone.repository.RecipeSampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.text.similarity.JaroWinklerDistance;





@Log4j2
@Service
@RequiredArgsConstructor
public class RecipeSampleServiceImpl implements RecipeSampleService {
    private final ModelMapper modelMapper;
    private final RecipeSampleRepository recipeSampleRepository;

    @Override
    public List<Long> searched(String keyword) throws RecipeIdExistException {
        List<String> recommendedKeywords = recommendKeywords(keyword);
        List<Long> recipeIds = recipeSampleRepository.findRecipeIdByKeywords(recommendedKeywords);
        if (recipeIds.isEmpty()) {
            throw new RecipeIdExistException();
        }
        return recipeIds;
    }

    @Override
    public List<String> recommendKeywords(String keyword) throws RecipeIdExistException {
        // 모든 키워드 가져오기
        List<String> allKeywords = recipeSampleRepository.findAllKeywords();

        // 추천 키워드 리스트 초기화
        List<String> recommendedKeywords = new ArrayList<>();

        // JaroWinklerDistance 객체 생성
        JaroWinklerDistance distance = new JaroWinklerDistance();

        // 모든 키워드와 입력한 키워드 비교하여 유사도가 0.8 이상인 경우 추천 키워드 리스트에 추가
        for (String k : allKeywords) {
            if (distance.apply(keyword, k) > 0.8) {
                recommendedKeywords.add(k);
            }
        }

        // 추천 키워드 리스트가 비어있는 경우 RecipeIdExistException 예외 처리
        if (recommendedKeywords.isEmpty()) {
            throw new RecipeIdExistException();
        }

        // 추천 키워드 리스트 반환
        return recommendedKeywords;
    }

//    private final ModelMapper modelMapper;
//    private final RecipeSampleRepository recipeSampleRepository;
//
//    @Override
//    public  List<Long> searched(String keyword) throws RecipeIdExistException {
//        List<Long> recipeIds = recipeSampleRepository.findRecipeIdByKeyword(keyword);
//        if (recipeIds.isEmpty()) {
//            throw new RecipeIdExistException();
//        }
//        return recipeIds;
//    }
//
////    추가
//    @Override
//    public List<String> recommendKeywords(String keyword) {
//        List<String> allKeywords = recipeSampleRepository.findAllKeywords();
//        List<String> recommendedKeywords = new ArrayList<>();
//
//        JaroWinklerDistance distance = new JaroWinklerDistance();
//        for (String k : allKeywords) {
//            if (distance.apply(keyword, k) > 0.8) {
//                recommendedKeywords.add(k);
//            }
//        }
//        return recommendedKeywords;
//    }
}
