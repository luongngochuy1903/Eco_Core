package com.ecofood.core.dto;
import java.util.List;
public record ProductProcessElementResponse<T>(String id,String processElementName,List<T> processElementAttribute) {}
