package com.succApplication.repositories;

import java.util.List;
import java.util.Map;

public interface ContextRepository {
    List<Map<String, Object>> getContexts(Integer templateId, String mode);
}
