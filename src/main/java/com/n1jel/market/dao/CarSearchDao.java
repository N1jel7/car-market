package com.n1jel.market.dao;

import com.n1jel.market.dto.request.car.CarFilterDto;
import com.n1jel.market.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class CarSearchDao {

    private final EntityManager em;

    public List<Car> findAllByFilter(CarFilterDto request) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Car> carCriteriaQuery = criteriaBuilder.createQuery(Car.class);
        List<Predicate> predicates = new ArrayList<>();

        // SELECT FROM CAR
        Root<Car> root = carCriteriaQuery.from(Car.class);

        if (request.getBrand() != null) {
            Predicate brandPredicate = criteriaBuilder.equal(root.get("brand"),  request.getBrand());
            predicates.add(brandPredicate);
        }

        if (request.getModel() != null) {
            Predicate modelPredicate = criteriaBuilder.equal(root.get("model"), request.getModel());
            predicates.add(modelPredicate);
        }

        if (request.getGeneration() != null) {
            Predicate generationPredicate = criteriaBuilder.equal(root.get("generation"), request.getGeneration());
            predicates.add(generationPredicate);
        }

        // price from X
        if (request.getPriceFrom() != null) {
            Predicate priceFromPredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("price"), request.getPriceFrom());
            predicates.add(priceFromPredicate);
        }

        // price to Y
        if (request.getPriceTo() != null) {
            Predicate priceFromPredicate = criteriaBuilder.lessThanOrEqualTo(root.get("price"), request.getPriceTo());
            predicates.add(priceFromPredicate);
        }

        carCriteriaQuery.where(
                criteriaBuilder.and(predicates.toArray(new Predicate[0]))
        );

        TypedQuery<Car> query = em.createQuery(carCriteriaQuery);
        return query.getResultList();
    }

}
