package com.tang.hwplib.objects.fileheader

import com.tang.hwplib.objects.docinfo.borderfill.fillinfo.HWPFillInfo

/**
 * 파일 인식 정보를 나타내는 객체
 * 한글의 문서 파일이라는 것을 나타내기 위해 사용
 *
 * @author accforaus
 *
 * @property [version] [HWPFileVersion], 파일 버전 (DWORD) (unsigned 4 bytes)
 * @property [compressed] [Boolean], 압축 여부 (bit 00)
 * @property [hasPassword] [Boolean], 암호 설정 여부 (bit 01)
 * @property [isDeploymentDocument] [Boolean], 배포용 문서 여부 (bit 02)
 * @property [saveScript] [Boolean], 스크립트 저장 여부  (bit 03)
 * @property [isDRMDocument] [Boolean], DRM 무서 보안 여부 (bit 04)
 * @property [hasXMLTemplate] [Boolean], XMLTemplate 스토리지 존재 여부 (bit 05)
 * @property [hasDocumentHistory] [Boolean], 문서 이력 관리 존재 여부 (bit 06)
 * @property [hasSignature] [Boolean], 전자 서명 정보 존재 여부 (bit 07)
 * @property [encryptPublicCertification] [Boolean], 공인 인증서 암호화 여부 (bit 08)
 * @property [savePrepareSignature] [Boolean], 전자 서명 예비 저장 여부 (bit 09)
 * @property [isPublicCertificationDRMDocument] [Boolean], 공인 인증서 DRM 보안 문서 여부 (bit 10)
 * @property [isCCLDocument] [Boolean], CCL 문서 여부 (bit 11)
 * @property [isMobileOptimize] [Boolean], 모바일 최적화 여부 (bit 12)
 * @property [isSecurityPersonalPrivacy] [Boolean], 개인 정보 보안 문서 여부 (bit 13)
 * @property [hasTrackChange] [Boolean], 변경 추적 문서 여부 (bit 14)
 * @property [hasKOGLCopyright] [Boolean], 공공누리(KOGL) 저작권 문서 (bit 15)
 * @property [hasVideoControl] [Boolean], 비디오 컨트롤 포함 여부 (bit 16)
 * @property [hasOrderFieldControl] [Boolean], 차례 필드 컨트롤 포함 여부 (bit 17)
 *
 * @property [koglCCLInfo] [HWPKOGLCCLInfo], CCL, 공공누리 라이센스 정보 등,(DWORD - unsigned 4 bytes)
 * @property [encryptVersionType] [HWPEncryptVersionType], Encrypt Version 정보 (DWORD - unsigned 4 bytes)
 * @property [koglLicenceSupportCountry] [HWPKOGLLicenceSupportCountry], 공공누리(KOGL) 라이센스 지원 국가 (BYTE - unsigned 1 byte)
 */
class HWPFileHeader {
    var version: HWPFileVersion = HWPFileVersion()
    var compressed: Boolean = false
    var hasPassword: Boolean = false
    var isDeploymentDocument: Boolean = false
    var saveScript: Boolean = false
    var isDRMDocument: Boolean = false
    var hasXMLTemplate: Boolean = false
    var hasDocumentHistory: Boolean = false
    var hasSignature: Boolean = false
    var encryptPublicCertification: Boolean = false
    var savePrepareSignature: Boolean = false
    var isPublicCertificationDRMDocument: Boolean = false
    var isCCLDocument: Boolean = false
    var isMobileOptimize: Boolean = false
    var isSecurityPersonalPrivacy: Boolean = false
    var hasTrackChange: Boolean =false
    var hasKOGLCopyright: Boolean = false
    var hasVideoControl: Boolean = false
    var hasOrderFieldControl: Boolean = false
    var koglCCLInfo: HWPKOGLCCLInfo = HWPKOGLCCLInfo()
    var encryptVersionType: HWPEncryptVersionType = HWPEncryptVersionType.None
    var koglLicenceSupportCountry: HWPKOGLLicenceSupportCountry = HWPKOGLLicenceSupportCountry.KOR

    /**
     * HWP 문서의 signature을 반환하는 함수
     * signature은 파일이 HWP 파일인지 여부를 체크하는데 사용된
     * 문서 파일은 "HWP Document FILE"
     * BYTE array[32] - [ByteArray]
     *
     * return [ByteArray], HWP 문서의 signature
     */
    companion object {
        fun getFileSignature() = byteArrayOf(
                0x48, 0x57, 0x50, 0x20, 0x44, 0x6f, 0x63, 0x75, 0x6d,
                0x65, 0x6e, 0x74, 0x20, 0x46, 0x69, 0x6c, 0x65, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00)

        /**
         * 객체를 생성하고 반환하는 함수
         *
         * @return [HWPFileHeader] 생성된 객체 반환
         */
        fun build(version: HWPFileVersion = HWPFileVersion.build(),
                  compressed: Boolean = false, hasPassword: Boolean = false,
                  isDeploymentDocument: Boolean = false, saveScript: Boolean = false,
                  isDRMDocument: Boolean = false, hasXMLTemplate: Boolean = false,
                  hasDocumentHistory: Boolean = false, hasSignature: Boolean = false,
                  encryptPublicCertification: Boolean = false, savePrepareSignature: Boolean = false,
                  isPublicCertificationDRMDocument: Boolean = false, isCCLDocument: Boolean = false,
                  isMobileOptimize: Boolean = false, isSecurityPersonalPrivacy: Boolean = false,
                  hasTrackChange: Boolean = false, hasKOGLCopyright: Boolean = false,
                  hasVideoControl: Boolean = false, hasOrderFieldControl: Boolean = false,
                  koglCCLInfo: HWPKOGLCCLInfo = HWPKOGLCCLInfo.build(), encryptVersionType: HWPEncryptVersionType = HWPEncryptVersionType.MoreHWP70,
                  koglLicenceSupportCountry: HWPKOGLLicenceSupportCountry = HWPKOGLLicenceSupportCountry.KOR
        ): HWPFileHeader = HWPFileHeader().apply {
            this.version = version
            this.compressed = compressed
            this.hasPassword = hasPassword
            this.isDeploymentDocument = isDeploymentDocument
            this.saveScript = saveScript
            this.isDRMDocument = isDRMDocument
            this.hasXMLTemplate = hasXMLTemplate
            this.hasDocumentHistory = hasDocumentHistory
            this.hasSignature = hasSignature
            this.encryptPublicCertification = encryptPublicCertification
            this.savePrepareSignature = savePrepareSignature
            this.isPublicCertificationDRMDocument = isPublicCertificationDRMDocument
            this.isCCLDocument = isCCLDocument
            this.isMobileOptimize = isMobileOptimize
            this.isSecurityPersonalPrivacy = isSecurityPersonalPrivacy
            this.hasTrackChange = hasTrackChange
            this.hasKOGLCopyright = hasKOGLCopyright
            this.hasVideoControl = hasVideoControl
            this.hasOrderFieldControl = hasOrderFieldControl
            this.koglCCLInfo = koglCCLInfo
            this.encryptVersionType = encryptVersionType
            this.koglLicenceSupportCountry = koglLicenceSupportCountry
        }
    }

    /**
     * 객체를 복사한 후 반환하는 함수
     *
     * @return [HWPFileVersion] 복사된 객체 반환
     */
    fun copy() : HWPFileHeader = HWPFileHeader().also {
        it.version = this.version.copy()
        it.compressed = this.compressed
        it.hasPassword = this.hasPassword
        it.isDeploymentDocument = this.isDeploymentDocument
        it.saveScript = this.saveScript
        it.isDRMDocument = this.isDRMDocument
        it.hasXMLTemplate = this.hasXMLTemplate
        it.hasDocumentHistory = this.hasDocumentHistory
        it.hasSignature = this.hasSignature
        it.encryptPublicCertification = this.encryptPublicCertification
        it.savePrepareSignature = this.savePrepareSignature
        it.isPublicCertificationDRMDocument = this.isPublicCertificationDRMDocument
        it.isCCLDocument = this.isCCLDocument
        it.isMobileOptimize = this.isMobileOptimize
        it.isSecurityPersonalPrivacy = this.isSecurityPersonalPrivacy
        it.hasTrackChange = this.hasTrackChange
        it.hasKOGLCopyright = this.hasKOGLCopyright
        it.hasVideoControl = this.hasVideoControl
        it.hasOrderFieldControl = this.hasOrderFieldControl
        it.koglCCLInfo = this.koglCCLInfo.copy()
        it.encryptVersionType = HWPEncryptVersionType.valueOf(this.encryptVersionType.value)
        it.koglLicenceSupportCountry = HWPKOGLLicenceSupportCountry.valueOf(this.koglLicenceSupportCountry.value)
    }
}