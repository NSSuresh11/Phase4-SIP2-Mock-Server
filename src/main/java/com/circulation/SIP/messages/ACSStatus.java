/* 
 * Copyright (C) 2020 Ceridwen Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.circulation.SIP.messages;

import com.circulation.SIP.annotations.Command;
import com.circulation.SIP.annotations.PositionedField;
import com.circulation.SIP.annotations.TaggedField;
import com.circulation.SIP.types.enumerations.ProtocolVersion;
import com.circulation.SIP.types.flagfields.SupportedMessages;

import java.util.Date;

@Command("98")
public class ACSStatus extends Message {
    private static final long serialVersionUID = -611426325284828647L;
    @PositionedField(start = 2, end = 2)
    private Boolean onlineStatus;
    @PositionedField(start = 3, end = 3)
    private Boolean checkInOk;
    @PositionedField(start = 4, end = 4)
    private Boolean checkOutOk;
    @PositionedField(start = 5, end = 5)
    private Boolean ACSRenewalPolicy;
    @PositionedField(start = 6, end = 6)
    private Boolean statusUpdateOk;
    @PositionedField(start = 7, end = 7)
    private Boolean offlineOk;
    @PositionedField(start = 8, end = 10)
    private Integer timeoutPeriod;
    @PositionedField(start = 11, end = 13)
    private Integer retriesAllowed;
    @PositionedField(start = 14, end = 31)
    private Date dateTimeSync;
    @PositionedField(start = 32, end = 35)
    private ProtocolVersion protocolVersion;
    @TaggedField
    private String institutionId;
    @TaggedField
    private String libraryName;
    @TaggedField
    private SupportedMessages supportedMessages = new SupportedMessages();
    @TaggedField
    private String terminalLocation;
    @TaggedField
    private String screenMessage;
    @TaggedField
    private String printLine;

    public Boolean isCheckInOk() {
        return this.checkInOk;
    }

    public Boolean isCheckOutOk() {
        return this.checkOutOk;
    }

    public Date getDateTimeSync() {
        return this.dateTimeSync;
    }

    public String getInstitutionId() {
        return this.institutionId;
    }

    public String getLibraryName() {
        return this.libraryName;
    }

    public Boolean isOfflineOk() {
        return this.offlineOk;
    }

    public Boolean isOnlineStatus() {
        return this.onlineStatus;
    }

    public String getPrintLine() {
        return this.printLine;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.protocolVersion;
    }

    public Boolean isACSRenewalPolicy() {
        return this.ACSRenewalPolicy;
    }

    public Integer getRetriesAllowed() {
        return this.retriesAllowed;
    }

    public String getScreenMessage() {
        return this.screenMessage;
    }

    public Boolean isStatusUpdateOk() {
        return this.statusUpdateOk;
    }

    public SupportedMessages getSupportedMessages() {
        return this.supportedMessages;
    }

    public String getTerminalLocation() {
        return this.terminalLocation;
    }

    public Integer getTimeoutPeriod() {
        return this.timeoutPeriod;
    }

    public void setTimeoutPeriod(Integer timeoutPeriod) {
        this.timeoutPeriod = timeoutPeriod;
    }

    public void setTerminalLocation(String terminalLocation) {
        this.terminalLocation = terminalLocation;
    }

    /**
     * Use getSupportedMessages().set(SupportedMessages.VALUE)
     * getSupportedMessages().unset(SupportedMessages.VALUE)
     * getSupportedMessages().unsetAll()
     */
    @Deprecated
    public void setSupportedMessages(SupportedMessages supportedMessages) {
        this.supportedMessages = supportedMessages;
    }

    public void setStatusUpdateOk(Boolean statusUpdateOk) {
        this.statusUpdateOk = statusUpdateOk;
    }

    public void setScreenMessage(String screenMessage) {
        this.screenMessage = screenMessage;
    }

    public void setRetriesAllowed(Integer retriesAllowed) {
        this.retriesAllowed = retriesAllowed;
    }

    public void setACSRenewalPolicy(Boolean ACSRenewalPolicy) {
        this.ACSRenewalPolicy = ACSRenewalPolicy;
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public void setPrintLine(String printLine) {
        this.printLine = printLine;
    }

    public void setOnlineStatus(Boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public void setOfflineOk(Boolean offlineOk) {
        this.offlineOk = offlineOk;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public void setDateTimeSync(Date dateTimeSync) {
        this.dateTimeSync = dateTimeSync;
    }

    public void setCheckOutOk(Boolean checkOutOk) {
        this.checkOutOk = checkOutOk;
    }

    public void setCheckInOk(Boolean checkInOk) {
        this.checkInOk = checkInOk;
    }
}
