package com.b1g4.jejudongggotgilrong.service;

import com.b1g4.jejudongggotgilrong.dto.GuestBookRequest;
import com.b1g4.jejudongggotgilrong.dto.GuestBookResponse;
import com.b1g4.jejudongggotgilrong.entity.BusStop;
import com.b1g4.jejudongggotgilrong.entity.GuestBook;
import com.b1g4.jejudongggotgilrong.entity.error.ApplicationError;
import com.b1g4.jejudongggotgilrong.entity.error.NotFoundException;
import com.b1g4.jejudongggotgilrong.repository.BusStopRepository;
import com.b1g4.jejudongggotgilrong.repository.GuestBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GuestBookService {

    private static final String[] AUTHOR = {
            "다푸른바다", "따스린해풀", "찰랑거리는폭포", "샌새는쑤", "까푸른해", "막둥글은밭", "찰랑거리는물건", "뚝바른길", "싱숭생숭산", "꼬매한바람",
            "노란유채", "흐린서리", "고요한해변", "꽈락거리는해", "말랑말랑한소금", "빙글빙글한달", "씨알같은바위", "꼬끄러기날개", "뚝딱거리는문", "쑥스러운딸기",
            "싱숭싱숭한잔디 ", "끈적끈적한꿀", "덜그럭덜그럭하는별 ", "달달한꿀벌", "곱슬곱슬한털", "짭짤한김밥", "살랑살랑하는바람", "무릎꿇는돌 ", "고요한바닷길", "꾀꼬리는풀",
            "따뜻한별빛", "꽃피는우주", "유쾌한가슴", "맛있는하모니", "착착꾸는버스 ", "푸푸부는바람", "아릿한선물", "쑥쑥자라는풀", "낡은소년", "부쩍크는별"
    };

    private final GuestBookRepository guestBookRepository;
    private final BusStopRepository busStopRepository;

    @Transactional(readOnly = true)
    public List<GuestBookResponse> getGuestBooksByRoute(Long routeId) {
        return guestBookRepository.findByRouteIdOrderByCreatedDateDesc(routeId)
                .stream()
                .map(guestBook -> GuestBookResponse.builder()
                        .author(guestBook.getAuthor())
                        .content(guestBook.getContent())
                        .createdDate(guestBook.getCreatedDate().toLocalDate())
                        .build())
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GuestBookResponse> getGuestBook(Long busStopId) {
        return guestBookRepository.findByBusStopIdOrderByCreatedDateDesc(busStopId)
                .stream()
                .map(guestBook -> GuestBookResponse.builder()
                        .author(guestBook.getAuthor())
                        .content(guestBook.getContent())
                        .createdDate(guestBook.getCreatedDate().toLocalDate())
                        .build())
                .toList();
    }

    @Transactional
    public void create(Long busStopId, GuestBookRequest guestBookRequest) {
        BusStop busStop = busStopRepository.findById(busStopId)
                .orElseThrow(() -> new NotFoundException(ApplicationError.BUS_STOP_NOT_FOUND));
        GuestBook guestBook = GuestBook.builder()
                .author(AUTHOR[(int) (Math.random() * AUTHOR.length)])
                .content(guestBookRequest.getContent())
                .busStop(busStop)
                .route(busStop.getRoute())
                .build();
        guestBookRepository.save(guestBook);
    }
}
