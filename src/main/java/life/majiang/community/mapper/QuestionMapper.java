package life.majiang.community.mapper;

import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modify,tag) values (#{title},#{description},#{gmtCreate},#{gmtModify},#{tag})")
    void create(Question question);
}
