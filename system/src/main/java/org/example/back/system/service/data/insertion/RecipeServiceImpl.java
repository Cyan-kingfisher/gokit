package org.example.back.system.service.data.insertion;

import org.example.back.system.service.feign.RecipeFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * @author cyan
 * @since 2022/6/6
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeFeignService recipeFeignService;

    @Override
    public void RecipeAudit(Model model, Integer id) {

    }
}
