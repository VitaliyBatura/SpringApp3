package org.example.service.impl;

public class VehicleServiceImpl {

//    private ObjectMapper objectMapper = new ObjectMapper();
//    private VehicleDaoImpl vehicleDao;
//    private TyreDaoImpl tyreDao;
//
//    VehicleMapper vehicleMapper = new VehicleMapper();
//
//    public VehicleServiceImpl(VehicleDaoImpl vehicleDao, TyreDaoImpl tyreDao) {
//
//        this.vehicleDao = vehicleDao;
//        this.tyreDao = tyreDao;
//    }
//
//    public VehicleServiceImpl(VehicleDaoImpl vehicleDao, TyreDaoImpl tyreDao, VehicleMapper vehicleMapper) {
//        this.vehicleDao = vehicleDao;
//        this.tyreDao = tyreDao;
//        this.vehicleMapper = vehicleMapper;
//    }
//
//    public VehicleServiceImpl() {
//
//    }
//
//    public Optional<String> handleGetRequest(String parameter) throws SQLException {
//
//        if (parameter == null) {
//            List<VehicleDto> vehicles = vehicleDao.readAll().stream().map(vehicle ->
//                    vehicleMapper.convertToVehicleDto(vehicle)).collect(Collectors.toList());
//            try {
//                return Optional.ofNullable(objectMapper.writeValueAsString(vehicles));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//            return Optional.empty();
//        } else {
//            int id = Integer.parseInt(parameter);
//            Vehicle vehicle = vehicleDao.readById(id);
//            VehicleDto vehicleDto = vehicleMapper.convertToVehicleDto(vehicle);
//            try {
//                return Optional.ofNullable(objectMapper.writeValueAsString(vehicleDto));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        }
//        return Optional.empty();
//    }
//
//    public void handlePostRequest(Vehicle vehicle) throws SQLException {
//
//        if (vehicle != null) {
//            vehicleDao.create(vehicle);
//        }
//    }
//
//    public void handlePutRequest(Vehicle vehicle) throws SQLException {
//
//        if (vehicle != null) {
//            vehicleDao.update(vehicle);
//        }
//    }
//
//    public void handleDeleteRequest(int vehicleId) throws SQLException {
//
//        vehicleDao.deleteById(vehicleId);
//    }
//
//    private static class VehicleServiceHolder {
//        private final static VehicleServiceImpl instance = new VehicleServiceImpl();
//    }
//
//    public static VehicleServiceImpl getInstance() {
//        return VehicleServiceHolder.instance;
//    }
}