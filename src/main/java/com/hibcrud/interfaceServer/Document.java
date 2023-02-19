package com.hibcrud.interfaceServer;

import java.util.Date;

public interface Document {

    /**
     * Возвращает уникальный идетификатор документа.
     * В перспективе должен совпадать с идетификатором файла.
     *
     * @return уникальный идетификатор документа
     */
    Integer getId();

    /**
     * Имя документа, заполняет человек.
     *
     * @return имя документа
     */
    String getName();

    void setName(String name);

    /**
     * Абстрактная дата документа.
     *
     * @return дата документа
     */
    Date getDate();

    void setDate(Date date);

    boolean isShared();

    void setShared(boolean isShared);

    /**
     * Является ли документ информационным. Например информационное письмо.
     *
     * @return является ли документ информационным
     */
    boolean isInfo();

    void setInfo(boolean isInfo);

    /**
     * Человекочетаемый источник документа. Т.е. документ из какой сущности.
     *
     * @return человекочетаемый источник документа.
     */
    String getForeignLabel();
}
