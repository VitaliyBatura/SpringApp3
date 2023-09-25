package org.example.service.impl;

public class TyreServiceImpl {

//    private ObjectMapper objectMapper = new ObjectMapper();
//    private TyreDaoImpl tyreDao;
//    TyreMapper tyreMapper = new TyreMapper();
//
//    public TyreServiceImpl(TyreDaoImpl tyreDao) {
//        this.tyreDao = tyreDao;
//    }
//
//    public TyreServiceImpl(TyreDaoImpl tyreDao, TyreMapper tyreMapper) {
//        this.tyreDao = tyreDao;
//        this.tyreMapper = tyreMapper;
//    }
//
//    public TyreServiceImpl() {
//
//    }
//
//
//    public Optional<String> handleGetRequest(String parameter) throws SQLException {
//
//        if (parameter == null) {
//            List<TyreDto> tyres = tyreDao.readAll().stream().map(tyre ->
//                    tyreMapper.convertToTyreDto(tyre)).collect(Collectors.toList());
//            try {
//                return Optional.ofNullable(objectMapper.writeValueAsString(tyres));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        } else {
//            int id = Integer.parseInt(parameter);
//            Tyre tyre = tyreDao.readById(id);
//            TyreDto tyreDto = new TyreDto();
//            if (tyre != null) {
//                tyreDto = tyreMapper.convertToTyreDto(tyre);
//            }
//            try {
//                return Optional.ofNullable(objectMapper.writeValueAsString(tyreDto));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        }
//        return Optional.empty();
//    }
//
//    public void handlePostRequest(Tyre tyre) throws SQLException {
//
//        if (tyre != null) {
//            tyreDao.create(tyre);
//        }
//    }
//
//    public void handlePutRequest(Tyre tyre) throws SQLException {
//
//        if (tyre != null) {
//            tyreDao.update(tyre);
//        }
//    }
//
//    public void handleDeleteRequest(int tyreId) throws SQLException {
//
//        tyreDao.deleteById(tyreId);
//    }
//
//    private static class TyreServiceHolder {
//        private final static TyreServiceImpl instance = new TyreServiceImpl();
//    }
//
//    public static TyreServiceImpl getInstance() {
//        return TyreServiceHolder.instance;
//    }
}