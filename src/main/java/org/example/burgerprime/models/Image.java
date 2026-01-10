package org.example.burgerprime.models;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String originalFileName;
    private Long size;
    private String type;
    private boolean isPreview;
    @Lob
    private byte[] data;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Product product;

    public Image() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getOriginalFileName() {
        return this.originalFileName;
    }

    public Long getSize() {
        return this.size;
    }

    public String getType() {
        return this.type;
    }

    public boolean isPreview() {
        return this.isPreview;
    }

    public byte[] getData() {
        return this.data;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPreview(boolean isPreview) {
        this.isPreview = isPreview;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Image)) return false;
        final Image other = (Image) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$originalFileName = this.getOriginalFileName();
        final Object other$originalFileName = other.getOriginalFileName();
        if (this$originalFileName == null ? other$originalFileName != null : !this$originalFileName.equals(other$originalFileName))
            return false;
        final Object this$size = this.getSize();
        final Object other$size = other.getSize();
        if (this$size == null ? other$size != null : !this$size.equals(other$size)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        if (this.isPreview() != other.isPreview()) return false;
        if (!java.util.Arrays.equals(this.getData(), other.getData())) return false;
        final Object this$product = this.getProduct();
        final Object other$product = other.getProduct();
        if (this$product == null ? other$product != null : !this$product.equals(other$product)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Image;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $originalFileName = this.getOriginalFileName();
        result = result * PRIME + ($originalFileName == null ? 43 : $originalFileName.hashCode());
        final Object $size = this.getSize();
        result = result * PRIME + ($size == null ? 43 : $size.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        result = result * PRIME + (this.isPreview() ? 79 : 97);
        result = result * PRIME + java.util.Arrays.hashCode(this.getData());
        final Object $product = this.getProduct();
        result = result * PRIME + ($product == null ? 43 : $product.hashCode());
        return result;
    }

    public String toString() {
        return "Image(id=" + this.getId() + ", name=" + this.getName() + ", originalFileName=" + this.getOriginalFileName() + ", size=" + this.getSize() + ", type=" + this.getType() + ", isPreview=" + this.isPreview() + ", data=" + java.util.Arrays.toString(this.getData()) + ", product=" + this.getProduct() + ")";
    }
}
