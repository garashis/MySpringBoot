package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Branch {
    private int requireReviewCount;
    private boolean dismissStaleReviews;
    private boolean requireCodeOwnerReview;
    private boolean requireBranchUpToDate;
    private boolean includeAdmin;
    private boolean requireLinearHistory;
    private boolean allowProtectedBranchDelete;
    private List<String> requiredStatusChecks;
    private List<String> patterns;
}
