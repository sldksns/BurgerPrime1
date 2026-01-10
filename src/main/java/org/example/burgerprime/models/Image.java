package org.example.burgerprime.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "images")
@Data
@RequiredArgsConstructor
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
}
