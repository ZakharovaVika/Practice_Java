class SimpleRoomService implements RoomService<Room> {  //  <Room>  заменить на  <?>  если требуется обрабатывать любой тип.

    @Override
    public void clean(Room room) {
        System.out.println("Комната " + room.getRoomNumber() + " убрана.");
    }

    @Override
    public void reserve(Room room) {
        if (room.isReserved()) {
            throw new RoomAlreadyReservedException("Комната " + room.getRoomNumber() + " уже забронирована.");
        }
        room.setReserved(true);
        System.out.println("Комната " + room.getRoomNumber() + " забронирована.");
    }

    @Override
    public void free(Room room) {
        room.setReserved(false);
        System.out.println("Комната " + room.getRoomNumber() + " освобождена.");
    }
}