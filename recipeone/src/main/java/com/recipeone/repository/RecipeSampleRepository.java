package com.recipeone.repository;

import com.recipeone.entity.RecipeSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeSampleRepository extends JpaRepository<RecipeSample,String> {

//    @Query("select r.id from RecipeSample r where r.title like %:keyword% or r.tag like %:keyword%")
//    List<Long> findRecipeIdByKeyword(@Param("keyword") String keyword);

//    @Query("select distinct k from (select title as k from RecipeSample union select tag as k from RecipeSample) as t")
//    List<String> findAllKeywords();

    @Query("SELECT rs.tag FROM RecipeSample rs")
    List<String> findAllKeywords();

//    @Query("SELECT DISTINCT rs.title FROM RecipeSample rs UNION SELECT DISTINCT rs.tag FROM RecipeSample rs")
//    List<String> findAllKeywords();

    @Query("select r.id from RecipeSample r where r.title like %:keyword% or r.tag like %:keyword%")
    List<Long> findRecipeIdByKeywords(List<String> keywords);

//    @Query("select r.id from RecipeSample r where r.title like %:keyword% or r.tag like %:keyword%")
//    List<Long> findRecipeIdByKeyword(@Param("keyword") String keyword);
//
//    @Query("select distinct k from (select title as k from RecipeSample union select tag as k from RecipeSample) as t")
//    List<String> findAllKeywords();

}


