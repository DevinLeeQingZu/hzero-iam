package org.hzero.iam.domain.service.authdata.impl;

import org.hzero.iam.domain.repository.AuthDataRepository;
import org.hzero.iam.domain.service.authdata.AbstractAuthDataProvider;
import org.hzero.iam.domain.service.authdata.condition.AuthDataCondition;
import org.hzero.iam.domain.service.authdata.vo.AuthDataVo;
import org.hzero.iam.infra.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 采购组织权限数据提供器
 *
 * @author bo.he02@hand-china.com 2020/05/26 13:59
 */
@Component
public class PurOrgAuthDataProvider extends AbstractAuthDataProvider {

    @Autowired
    public PurOrgAuthDataProvider(AuthDataRepository authDataRepository) {
        super(authDataRepository);
    }

    @Override
    public String getAuthorityTypeCode() {
        return Constants.AUTHORITY_TYPE_CODE.PURORG;
    }

    @Override
    public List<AuthDataVo> findAuthData(@Nonnull String authorityTypeCode, @Nonnull AuthDataCondition authDataCondition) {
        return this.singleAuthDataVo(this.getAuthDataRepository().queryPurOrgDataSourceInfo(authDataCondition));
    }
}
