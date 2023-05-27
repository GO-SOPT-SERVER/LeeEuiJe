package org.sopt.SeventhSeminar.infrastructure;

import org.sopt.SeventhSeminar.domain.Board;
import org.springframework.data.repository.Repository;

public interface BoardRepository extends Repository<Board, Long> {
    void save(Board board);
}
