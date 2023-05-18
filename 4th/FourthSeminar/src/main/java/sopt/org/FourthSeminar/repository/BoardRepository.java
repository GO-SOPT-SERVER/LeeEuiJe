package sopt.org.FourthSeminar.repository;

import org.springframework.data.repository.Repository;
import sopt.org.FourthSeminar.domain.Board;

public interface BoardRepository extends Repository<Board, Long> {

    // CREATE
    void save(Board board);

    // READ

    // UPDATE

    // DELETE
}