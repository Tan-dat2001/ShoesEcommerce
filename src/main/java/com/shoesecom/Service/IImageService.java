package com.shoesecom.Service;

import com.shoesecom.Model.Image;

import java.util.List;

public interface IImageService{
    List<Image> getAllImage();

    Image getImageById(int id);

    Image getImageByProductId(int productId);
}
