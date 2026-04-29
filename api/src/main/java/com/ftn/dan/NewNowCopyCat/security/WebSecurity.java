//package com.ftn.dan.NewNowCopyCat.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//import rs.ftn.RedditCopyCat.model.DTO.CommunityDTO;
//import rs.ftn.RedditCopyCat.model.entity.Post;
//import rs.ftn.RedditCopyCat.model.entity.Report;
//import rs.ftn.RedditCopyCat.model.entity.User;
//import rs.ftn.RedditCopyCat.service.*;
//
//import javax.servlet.http.HttpServletRequest;
//
////https://docs.spring.io/spring-security/site/docs/5.2.11.RELEASE/reference/html/authorization.html
//
//@Component
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurity {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private PostService postService;
//    @Autowired
//    private CommentService commentService;
//    @Autowired
//    private ReactionService reactionService;
//    @Autowired
//    private ReportService reportService;
//
//    public boolean moderatesLocation(Authentication authentication, HttpServletRequest request, Long locationId) {
//        if (authentication == null)
//            return false;
//        User moderator = userService.findByUsername(authentication.getName());
//        if (moderator == null)
//            return false;
//        if (!userService.moderatesCommunity(locationId, moderator))
//            return false;
//        return true;
//    }
//
//    public boolean isUserLogged(Authentication authentication, HttpServletRequest request) {
//        if ( authentication == null)
//            return false;
//        return true;
//    }
//
//    public boolean canChangeComment(Authentication authentication, HttpServletRequest request, Long postId, Long commentId) {
//        if (authentication == null)
//            return false;
//        User loggedUser = userService.findByUsername(authentication.getName());
//        if (loggedUser == null)
//            return false;
//
//        if (!canUserParttake(authentication, request, postId) || !commentService.isAuthor(commentId, loggedUser.getId()))
//            return false;
//        return true;
//    }
//
//    public boolean canChangeReaction(Authentication authentication, HttpServletRequest request, Long reactionId) {
//        if (authentication == null)
//            return false;
//        User loggedUser = userService.findByUsername(authentication.getName());
//        if (loggedUser == null)
//            return false;
//
//        Post foundPost = postService.findByReactionId(reactionId);
//
//        if (foundPost == null || !canUserParttake(authentication, request, foundPost.getId()) || !reactionService.isAuthor(reactionId, loggedUser.getId()))
//            return false;
//        return true;
//    }
//
//    public boolean canReactToComment(Authentication authentication, HttpServletRequest request, Long commentId) {
//        if (authentication == null)
//            return false;
//        User loggedUser = userService.findByUsername(authentication.getName());
//        Post foundPost = postService.findByCommentId(commentId);
//
//        if (foundPost == null || loggedUser == null ||
//                reactionService.existsForComment(commentId, loggedUser) ||
//                !canUserParttake(authentication, request, foundPost.getId()) )
//        {
//            return false;
//        }
//        return true;
//    }
//}
