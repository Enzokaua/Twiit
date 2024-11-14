package ek.app.social.dto;

import java.util.List;

public record IndexDto (List<FeedDto> indexDto,
                        int page,
                        int pageSize,
                        int totalPages,
                        long totalElements) {
}
