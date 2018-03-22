package me.anqi.jexam.service;

import me.anqi.jexam.repository.NoticeRepository;
import me.anqi.jexam.repository.UserRepository;
import me.anqi.jexam.service.inter.NoticeSer;
import me.anqi.jexam.entity.Notice;
import me.anqi.jexam.entity.User;
import me.anqi.jexam.entity.auxiliary.UserAuxiliary;
import me.anqi.jexam.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class NoticeSerImpl implements NoticeSer {

    private NoticeRepository noticeRepository;
    private UserRepository userRepository;

    @Autowired
    public NoticeSerImpl(NoticeRepository noticeRepository, UserRepository userRepository) {
        this.noticeRepository = noticeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addComment(HttpServletRequest request, Notice notice,int type) {
        UserAuxiliary auxiliary= RequestUtils.getUserAuxiliaryFromReq(request);
        if (auxiliary==null) return;

        notice.setCreatedAt(new Date());
        notice.setType(type);
        notice.setFromUserId(auxiliary.getId());
        notice.setFromUserName(auxiliary.getName());
        notice.setOwner(new User(notice.getFrontOwnerId()));

        noticeRepository.save(notice);
        userRepository.noticeNumPlusOne(notice.getFrontOwnerId());
    }

    @Override
    public List<Notice> getCrsNotice(long fromInfoId) {
        return noticeRepository.findByTypeAndFromInfoId(1,fromInfoId);
    }

    @Override
    public List<Notice> getExeNotice(long fromInfoId) {
        return noticeRepository.findByTypeAndFromInfoId(2,fromInfoId);
    }
}
