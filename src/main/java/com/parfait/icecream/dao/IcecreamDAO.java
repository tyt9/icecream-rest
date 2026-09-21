package com.parfait.icecream.dao;

import com.parfait.icecream.dto.Product;
import com.parfait.icecream.dto.Topping;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IcecreamDAO {
    public List<Product> selectProduct();
    public List<Topping> selectTopping();
}
