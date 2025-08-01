package com.springbootTz.ZNYY.tool;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

@Component
public class OrgCodeQueryTool {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据机构名称（display）查询对应的code
     * 
     * @param displayName 机构名称
     * @return code值，找不到返回null
     */
    public String getCodeByDisplay(String displayName) {
        // $lookup
        AggregationOperation lookup = Aggregation.lookup(
                "ours_enum", // from
                "enumId", // localField
                "_id", // foreignField
                "enumType" // as
        );

        // $match
        Criteria matchCriteria = Criteria.where("enumType")
                .elemMatch(Criteria.where("name").is("医疗机构与统一社会编码"))
                .and("display").is(displayName);

        AggregationOperation match = Aggregation.match(matchCriteria);

        // $project
        AggregationOperation project = Aggregation.project("code").andExclude("_id");

        Aggregation aggregation = Aggregation.newAggregation(lookup, match, project);

        List<Document> results = mongoTemplate.aggregate(aggregation, "ours_enum_value", Document.class)
                .getMappedResults();

        if (results != null && !results.isEmpty()) {
            return results.get(0).getString("code");
        }
        return null;
    }
}