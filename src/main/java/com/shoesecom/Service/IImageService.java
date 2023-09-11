package com.shoesecom.Service;

import com.shoesecom.Model.Image;

import java.util.List;

public interface IImageService{
    List<Image> getAllImage();

    Image getImageById(int id);

    Image getImageByProductId(int productId);

    void addImage(Image image);

    void editImage(Image image);

    void deleteImage(int id);
}
