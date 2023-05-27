package org.sopt.SeventhSeminar.infrastructure;

import org.sopt.SeventhSeminar.domain.Image;
import org.springframework.data.repository.Repository;

public interface ImageRepository extends Repository<Image, Long> {
    // CREATE
    void save(Image image);
}