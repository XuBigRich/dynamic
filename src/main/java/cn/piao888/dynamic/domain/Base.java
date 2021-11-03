package cn.piao888.dynamic.domain;

/**
 * @author 许鸿志
 * @since 2021/11/3
 */
public class Base {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String id;
    private String name;
}
