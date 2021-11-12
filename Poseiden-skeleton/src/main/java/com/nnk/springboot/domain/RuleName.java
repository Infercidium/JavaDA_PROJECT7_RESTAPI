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

    /**
     * Attribute id corresponding to id generate.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * Attribute name corresponding to name choice.
     */
    @NotBlank(message = "Name is mandatory")
    private String name;

    /**
     * Attribute description corresponding to description choice.
     */
    @NotBlank(message = "Description is mandatory")
    private String description;

    /**
     * Attribute json corresponding to json choice.
     */
    @NotBlank(message = "Json is mandatory")
    private String json;

    /**
     * Attribute template corresponding to template choice.
     */
    @NotBlank(message = "Template is mandatory")
    private String template;

    /**
     * Attribute sqlStr corresponding to sqlStr choice.
     */
    @NotBlank(message = "SqlStr is mandatory")
    private String sqlStr;

    /**
     * Attribute sqlPart corresponding to sqlPart choice.
     */
    @NotBlank(message = "SqlPart is mandatory")
    private String sqlPart;

    /**
     * Test constructor.
     * @param nameC attribute.
     * @param descriptionC attribute.
     * @param jsonC attribute.
     * @param templateC attribute.
     * @param sqlStrC attribute.
     * @param sqlPartC attribute.
     */
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

    /**
     * ToString method.
     * @return toString.
     */
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

    /**
     * Equals method.
     * @param o : element to compare.
     * @return result of the comparison.
     */
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

    /**
     * HashCode method.
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
