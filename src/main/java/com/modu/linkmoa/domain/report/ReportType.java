package com.modu.linkmoa.domain.report;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReportType {
    POLICY1("유출/사칭/사기"),
    POLICY2("낚시/놀람/도배"),
    POLICY3("정당/정치인 비하 및 선거운동"),
    POLICY4("욕설/비하"),
    POLICY5("상업적 광고 및 판매"),
    POLICY6("어플 성격에 부적절함"),
    POLICY7("불건전한 미디어");

    private final String name;
}

