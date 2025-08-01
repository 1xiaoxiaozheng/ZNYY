package com.springbootTz.ZNYY.tool;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnumValueQueryTool {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据枚举名称和枚举号查询display值
     * 
     * @param enumName 枚举名称（如"证件类型"）
     * @param value    枚举号（如1）
     * @return display值，查不到返回空字符串
     */
    public String getDisplayByEnumNameAndValue(String enumName, long value) {
        // $lookup
        AggregationOperation lookup = Aggregation.lookup(
                "ours_enum",
                "enumId",
                "_id",
                "enumType");
        // $match
        Criteria matchCriteria = Criteria.where("enumType")
                .elemMatch(Criteria.where("name").is(enumName))
                .and("value").is(value);
        AggregationOperation match = Aggregation.match(matchCriteria);
        // $project
        AggregationOperation project = Aggregation.project("display").andExclude("_id");
        Aggregation aggregation = Aggregation.newAggregation(lookup, match, project);
        List<Document> results = mongoTemplate.aggregate(aggregation, "ours_enum_value", Document.class)
                .getMappedResults();
        if (results != null && !results.isEmpty()) {
            return results.get(0).getString("display");
        }
        return "";
    }
}