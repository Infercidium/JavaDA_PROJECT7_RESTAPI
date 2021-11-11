package com.nnk.springboot.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "rulename")
@Getter @Setter @NoArgsConstructor
public class RuleName {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public RuleName(final String nameC, final String descriptionC,
                    final String jsonC, final String templateC,
                    final String sqlStrC, final String sqlPartC) {
        this.name = nameC;
        this.description = descriptionC;
        this.json = jsonC;
        this.template = templateC;
        this.sqlStr = sqlStrC;
        this.sqlPart = sqlPartC;
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
