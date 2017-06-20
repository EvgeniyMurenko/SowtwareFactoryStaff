package com.SoftwareFactoryStaff.service;


import com.SoftwareFactoryStaff.model.FxmPost;

import java.util.List;

public interface FxmPostService {

    void addNewFxmPost(FxmPost fxmPost);

    void updateFxmPost(FxmPost fxmPost);

    void deleteFxmPost(FxmPost fxmPost);

    List<FxmPost> getAllFxmPosts();

    FxmPost getFxmPostById(Long id);

}
