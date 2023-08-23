package com.shoesecom.DAO;

import com.shoesecom.Model.Image;

import java.util.List;

public interface IImageDAO {
    List<Image> getAllImage();

    Image getImageById(int id);

    Image getImageByProductId(int productId);
}
