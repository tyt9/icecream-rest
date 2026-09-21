package com.parfait.icecream.service;

import com.parfait.icecream.dao.IcecreamDAO;
import com.parfait.icecream.dto.Product;
import com.parfait.icecream.dto.Topping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final IcecreamDAO icecreamDAO;

    public List<Product> selectProduct() {
        return icecreamDAO.selectProduct();
    }
    public List<Topping> selectTopping() {
        return icecreamDAO.selectTopping();
    }
}
