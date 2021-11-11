package com.nnk.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "rulename")
public class RuleName {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotBlank(message = "Json is mandatory")
    private String json;

    @NotBlank(message = "Template is mandatory")
    private String template;

    @NotBlank(message = "SqlStr is mandatory")
    private String sqlStr;

    @NotBlank(message = "SqlPart is mandatory")
    private String sqlPart;

    public RuleName() {
    }

    public RuleName(final String nameC, final String descriptionC, final String jsonC, final String templateC, final String sqlStrC, final String sqlPartC) {
        this.name = nameC;
        this.description = descriptionC;
        this.json = jsonC;
        this.template = templateC;
        this.sqlStr = sqlStrC;
        this.sqlPart = sqlPartC;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getSqlStr() {
        return sqlStr;
    }

    public void setSqlStr(String sqlStr) {
        this.sqlStr = sqlStr;
    }

    public String getSqlPart() {
        return sqlPart;
    }

    public void setSqlPart(String sqlPart) {
        this.sqlPart = sqlPart;
    }

    @Override
    public String toString() {
        return "RuleName{"
                + "id = " + id
                + ", name = '" + name + '\''
                + ", description = '" + description + '\''
                + ", json = '" + json + '\''
                + ", template = '" + template + '\''
                + ", sqlStr = '" + sqlStr + '\''
                + ", sqlPart = '" + sqlPart + '\''
                + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RuleName)) {
            return false;
        }
        RuleName ruleName = (RuleName) o;
        return getId().equals(ruleName.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
