package org.sopt.SixthSeminar.infrastructure;

import org.sopt.SixthSeminar.domain.Board;
import org.springframework.data.repository.Repository;

public interface BoardRepository extends Repository<Board, Long> {
    void save(Board board);
}
