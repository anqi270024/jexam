package me.anqi.jexam.service.inter;

import me.anqi.jexam.entity.Solution;
import me.anqi.jexam.entity.auxiliary.CodeForm;
import me.anqi.jexam.entity.auxiliary.CodeResult;

public interface CodeSer {

     Solution submitCode(String userId, CodeForm codeForm);

     CodeResult getResult(long solution_id);

}
